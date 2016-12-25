package test.tinyjdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.drinkjava2.BeanBox;
import com.github.drinkjava2.jsqlbox.tinyjdbc.TinyJdbc;

import test.config.JBeanBoxConfig.DataSourceBox;
import test.config.TestPrepare;

/**
 * This is to test TinyJDBC use its own Transaction not related to Spring<br/>
 * An exception will causer Spring rollback but will not affect TinyJDBC
 *
 * @author Yong Zhu
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class TinyJdbcBatchInsert {
	@Before
	public void setup() {
		TestPrepare.prepareDatasource_SetDefaultSqlBoxConetxt_RecreateTables();
	}

	@After
	public void cleanUp() {
		TestPrepare.closeDatasource_CloseDefaultSqlBoxConetxt();
	}

	@Test
	public void doTest() {
		DataSource ds = BeanBox.getBean(DataSourceBox.class);
		List<List<Object>> args = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			List<Object> arg = new ArrayList<>();
			arg.add(i);
			args.add(arg);
		}
		TinyJdbc.executeBatch(ds, TinyJdbc.TRANSACTION_READ_COMMITTED, "insert into users (age) values(?)", args);
		Assert.assertEquals(1000, (int) TinyJdbc.queryForInteger(ds, TinyJdbc.TRANSACTION_READ_COMMITTED,
				"select count(*) from users"));
	}

}