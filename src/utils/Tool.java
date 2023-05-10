package utils;

import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tool {
    public static Normal normalLogin(String normalIdForLoginStr, String normalPasswordForLogin) {
        int normalIdForLogin = 0;
        try {
            normalIdForLogin = Integer.parseInt(normalIdForLoginStr);
        } catch (Exception e){
            System.out.println("获取的id为空");
        }
        Normal normal = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ht?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8","root","123456");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from normal;");
            boolean flag = true;
            while (resultSet.next()){
                if (resultSet.getInt("normalId") == normalIdForLogin && resultSet.getString("password").equals(normalPasswordForLogin)){
                    normal = new Normal(
                            resultSet.getInt("normalId"), resultSet.getString("password"), resultSet.getString("name"),
                            resultSet.getString("gender"), resultSet.getString("phoneNumber"), resultSet.getString("address")
                    );
                    flag = false;
                    break;
                }
            }
            if (flag){
                showMessage("账号不存在或密码错误！");
            }
            statement.close();
            resultSet.close();
        }catch (SQLException e){
            System.out.println("normal 登录过程中出错");
        }
        return normal;
    }

    public static Tutor tutorLogin(String tutorIdForLoginStr, String tutorPasswordForLogin) {
        int tutorIdForLogin = 0;
        try {
            tutorIdForLogin = Integer.parseInt(tutorIdForLoginStr);
        } catch (Exception e){
            System.out.println("获取的id为空");
        }
        Tutor tutor = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ht?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8","root","123456");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from tutor;");
            boolean flag = true;
            while (resultSet.next()){
                if (resultSet.getInt("tutorId") == tutorIdForLogin && resultSet.getString("password").equals(tutorPasswordForLogin)){
                    tutor = new Tutor(
                            resultSet.getInt("tutorId"), resultSet.getString("password"), resultSet.getString("name"),
                            resultSet.getString("gender"), resultSet.getString("phoneNumber"), resultSet.getString("subject"),
                            resultSet.getInt("hourlyWage"), resultSet.getString("freeTime"), resultSet.getString("background")
                    );
                    flag = false;
                    break;
                }
            }
            if (flag){
                showMessage("账号密码未找到！");
            }
            statement.close();
            resultSet.close();
        }catch (SQLException e){
            System.out.println("Tutor 登录过程中出错");
        }
        return tutor;
    }

    public static ArrayList<Tutor> letSuitableTutorsIntoArrayList(String QuerySQL){
        ArrayList<Tutor> tutorArrayList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ht?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8","root","123456");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QuerySQL);
            Tutor tutor;
            while (resultSet.next()){
                tutor = new Tutor(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9));
                tutorArrayList.add(tutor);
            }
            statement.close();
            resultSet.close();
        }catch (SQLException e){
            System.out.println("读取数据库中Tutors出错");
        }
        return tutorArrayList;
    }

    public static ArrayList<Agreement> letSuitableAgreementsIntoArrayList(String QuerySQL){
        ArrayList<Agreement> agreementArrayList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ht?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8","root","123456");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QuerySQL);
            Agreement agreement;
            while (resultSet.next()){
                agreement = new Agreement(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),
                        resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9));
                agreementArrayList.add(agreement);
            }
            statement.close();
            resultSet.close();
        }catch (SQLException e){
            System.out.println("读取数据库中Agreement出错");
        }
        return agreementArrayList;
    }

    public static Object[][] SearchTutor(ArrayList<Tutor> tutorList){
        Object [][] tutorData_Object_TD_ArrayList = new Object[tutorList.size()][8];
        for (int i = 0; i < tutorList.size(); i++) {
            Tutor tutor = tutorList.get(i);
            tutorData_Object_TD_ArrayList[i][0] = tutor.getTutorId();
            tutorData_Object_TD_ArrayList[i][1] = tutor.getName();
            tutorData_Object_TD_ArrayList[i][2] = tutor.getSubject();
            tutorData_Object_TD_ArrayList[i][3] = tutor.getGender();
            tutorData_Object_TD_ArrayList[i][4] = tutor.getFreeTime();
            tutorData_Object_TD_ArrayList[i][5] = tutor.getHourlyWage();
            tutorData_Object_TD_ArrayList[i][6] = tutor.getBackground();
            tutorData_Object_TD_ArrayList[i][7] = tutor.getPhoneNumber();
        }
        return tutorData_Object_TD_ArrayList;
    }

    public static Object[][] SearchAgreement(ArrayList<Agreement> agreementList){
        Object [][] agreementData_Object_TD_ArrayList = new Object[agreementList.size()][8];
        for (int i = 0; i < agreementList.size(); i++) {
            Agreement agreement = agreementList.get(i);
            agreementData_Object_TD_ArrayList[i][0] = agreement.getAgreementId();
            agreementData_Object_TD_ArrayList[i][1] = agreement.getPartyA();
            agreementData_Object_TD_ArrayList[i][2] = agreement.getPartyB();
            agreementData_Object_TD_ArrayList[i][3] = agreement.getSubject();
            agreementData_Object_TD_ArrayList[i][4] = agreement.getAddress();
            agreementData_Object_TD_ArrayList[i][5] = agreement.getFreeTime();
            agreementData_Object_TD_ArrayList[i][6] = agreement.getTotalFee();
        }
        return agreementData_Object_TD_ArrayList;
    }


    public static Tutor getTheTutorInfo(String QuerySQL){
        Tutor tutor = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ht?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8","root","123456");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QuerySQL);
            while (resultSet.next()){
                tutor = new Tutor(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9));
                System.out.println(tutor.getTutorId()+tutor.getName());
            }
            statement.close();
            resultSet.close();
        }catch (SQLException e){
            System.out.println("获取特定的Tutor出错");
        }
        return tutor;
    }

    public static void OrderTutor(Normal normal, String QuerySQL){
        Tutor tutor = getTheTutorInfo(QuerySQL);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ht?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8","root","123456");
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("select * from agreement;");
            int id = createNewId("agreement");

            String SQL = "INSERT INTO ht.agreement (agreementId, partA, normalIdInAgreement, partB, tutorIdInAgreement, subject, address, freeTime, totalFee) VALUES (" +
                    id+", '"+normal.getName()+"', "+normal.getNormalId()+", '"+tutor.getName()+"', "+tutor.getTutorId()+", '"+tutor.getSubject()+"', '"+normal.getAddress()+"', '"+
                    tutor.getFreeTime()+"', null);";
            statement.executeLargeUpdate(SQL);
            System.out.println(SQL);

            statement.close();
            resultSet.close();
        }catch (SQLException e){
            System.out.println("建立协议失败！");
        }

    }

    public static int createNewId(String type){
        int id = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ht?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8","root","123456");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from "+type+";");
            Random random = new Random();
            id = random.nextInt(999999);
            ArrayList<Integer> idList = new ArrayList<>();
            int i = 0;
            while (resultSet.next()){
                idList.add(resultSet.getInt(type+"Id"));
            }
            while (true){
                if (!idList.contains(id)){
                    break;
                }
            }
            statement.close();
            resultSet.close();
        }catch (SQLException e){
            showMessage("生成新 "+type+" id出错");
        }
        return id;
    }

    public static void execute(String SQL, String error, String success){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ht?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8","root","123456");
             Statement statement = connection.createStatement()) {
            statement.executeLargeUpdate(SQL);
        }catch (SQLException e){
            showMessage(error);
        }
        showMessage(success);
    }

    public static boolean notExists(int id, String type){
        boolean b = false;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ht?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8","root","123456");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from "+type+";");
            ArrayList<Integer> idList = new ArrayList<>();
            while (resultSet.next()){
                idList.add(resultSet.getInt(type+"Id"));
            }
            while (true){
                if (!idList.contains(id)){
                    b = true;
                    break;
                }
            }
            statement.close();
            resultSet.close();
        }catch (SQLException e){
            showMessage("查询出现问题！");
        }
        return b;
    }

    public static void showMessage(String message){
        new Message(message,500);
    }
    public static void showMessage(String message, int width){
        new Message(message, width);
    }

}
