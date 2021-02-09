import java.util.ArrayList;
import oracle.jdbc.driver.OracleDriver;
public class testGRADLE {
public static void main(String[] args) {
System.out.println("TEST");
testJDBC testJDBC = new testJDBC();
ArrayList<String> arrayList = new ArrayList<>();
arrayList=testJDBC.selectDB("select * from version","name");
for ( String s : arrayList){
System.out.println(s);
}
}
}
