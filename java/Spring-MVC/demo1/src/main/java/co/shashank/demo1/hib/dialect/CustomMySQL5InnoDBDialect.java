package co.shashank.demo1.hib.dialect;



import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.function.StandardSQLFunction;

public class CustomMySQL5InnoDBDialect extends MySQL5InnoDBDialect {

	public CustomMySQL5InnoDBDialect() {
		super();
        registerFunction("charset", new StandardSQLFunction("charset"));
       
	}
}
