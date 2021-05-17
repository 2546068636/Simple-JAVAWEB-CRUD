import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Dao {// dao层

	public Dao() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public boolean insert(Bean bean) {// 插入数据的方法
		boolean f = false;
		String sql = "insert into info(id,name,password,sex) values('" + bean.getId() + "','" + bean.getName() + "','"
				+ bean.getPassword() + "','" + bean.getSex() + "')";
		Connection conn = DBUtil.getConnection();// 数据库连接，加载驱动
		Statement state = null;
		try {
			state = conn.createStatement();// 实例化Statement对象,方便对sql语句进行操作
			System.out.println(conn);
			state.executeUpdate(sql);
			f = true;
			// 执行数据库更新操作用于执行INSERT、UPDATE或DELETE语句以及SQLDDL（数据定义语言）语句，
			// 例如CREATETABLE和DROPTABLE,（创建表和删除表）
		} catch (Exception e)// 当try语句中s出现异常时，会执行catch中的语句
		{
			e.printStackTrace();// 捕获异常的语句
		} finally // finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），经常被用在需要释放资源的情况下。
		{
			DBUtil.close(conn);
		}
		return f;
	}

	public boolean delete(int id) {// 删除方法
		String sql = "delete from info where id='" + id + "'";
		boolean f = false;
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(st, conn);
		}
		return f;
	}

	public boolean update(Bean bean) {// 更新方法
		String sql = "update info set name='" + bean.getName() + "',password='" + bean.getPassword() + "',sex='"
				+ bean.getSex() + "'where id='" + bean.getId() + "'";
		Connection conn = DBUtil.getConnection();
		boolean f = false;
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public List<Bean> list() {// 遍历
		String sql = "select * from info order by id ASC";
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		List<Bean> list = new ArrayList<>();
		ResultSet rs = null;
		Bean bean = null;
		try {
			st = conn.createStatement();
			st.executeQuery(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String sex = rs.getString("sex");
				bean = new Bean(id, name, password, sex);
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, st, conn);
		}
		return list;
	}

}
