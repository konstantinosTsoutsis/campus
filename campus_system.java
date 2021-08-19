package sqltest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.mysql.jdbc.Statement;
import java.util.Date;  
public class sqlExam {

	
	
	public static void main(String[] args) throws Exception {
		System.out.println("Select an option : \n"
				+ "[1] Insert values \n"
				+ "[2] Show the courses\n"
				+ "[3] Show the teachers\n"
				+ "[4] Show the soupervisors\n"
				+ "[5] Show if a specific student passed a course\n"
				+ "[6] Show and delete over Duration student");
		
		
		Scanner choiceScanner = new Scanner(System.in);  // Create a Scanner object
	    
	    String choice = choiceScanner.nextLine();  // Read user input
	    Scanner info = new Scanner(System.in);
	    if (choice.equals("1")) {
	    	System.out.println("you choose to insert values");
	    	insert1();
	    }
	    else if (choice.equals("2")) {
	    	select_courses();
	    }
	    else if(choice.equals("3")) {
	    	select_teacher();
	    }
	    else if(choice.equals("4")) {
	    	select_supervisor();
	    }
	    else if(choice.equals("5")) {
	    	System.out.println("Enter student id");
	    	String student = info.nextLine();
	    	System.out.println("Enter course id");
	    	String course = info.nextLine();
	    	passed_course(student,course);
	    }
	    else if(choice.equals("6")) {
	    	System.out.println("Enter curriculum id");
	    	String curriculum = info.nextLine();
	    	over_Due(curriculum);
	    }
	   
	   

	    }

	    public static void insert1() throws Exception{
	    	Connection con = getConnection(); //connection to database
	    	System.out.println("if you want to insert values on campus press 'campus'\nif you want to insert values on faculty press 'faculty'\n"
	    			+ "if you want to insert values on	department press 'department'\nif you want to insert values on curriculum press 'curriculum'\n"
	    			+ "if you want to insert values on teacher press 'teacher'\nif you want to insert values on supervisor press 'supervisor\n"
	    			+ "if you want to insert values on course press 'course\nif you want to insert values on prerequisite press 'prerequisite'\n"
	    			+ "if you want to insert values on student press 'student\nif you want to insert course info in a specific student press 'student_course'\n"
	    			+ "if you want to insert values on commission press 'commission");
			Scanner choiceScanner = new Scanner(System.in);  // Create a Scanner object		    
		    String choice = choiceScanner.nextLine();  // Read user input
		    
	    	if (choice.equals("campus")) {
		    	
		    	Scanner inputsForcampus = new Scanner(System.in);
		    	Scanner campusBusNumber = new Scanner(System.in);
		    	
		    	System.out.println("Enter campus name :");
		    	final String campusName  = inputsForcampus.nextLine();
		    	
		    	System.out.println("Enter campus addres");
		    	final String campusAddres  = inputsForcampus.nextLine();
		    	
		    	System.out.println("Enter campus distance");
		    	final String campusDistance  = inputsForcampus.nextLine();
		    	
		    	System.out.println("Enter campus bus number");
		    	int campusbusNumber = campusBusNumber.nextInt();
		    	
		    	
		    	System.out.println("Enter campus club");
		    	final String campusClub  = inputsForcampus.nextLine();
		    			
		    	try {
		            
		            PreparedStatement posted = con.prepareStatement("INSERT INTO campus (campus_name, address, distance, bus_num, club_club_name , club_club_name1) "
		            		+ "VALUES ('"+campusName+"', '"+campusAddres+"', '"+campusDistance+"', '"+campusbusNumber+"', '"+campusClub+"', '"+campusClub+"') ");

		            posted.executeUpdate();
		            
		        	}
		    	catch(Exception e) {
		    		System.out.println(e);
		    		}
		    finally {System.out.println("Insert Completed");}
		    	
			
		    }//end if for campus choice
	    	else if (choice.equals("faculty")) {
	    		
	    		Scanner inputsForFaculty = new Scanner(System.in);
	    		
	    		System.out.println("Enter Faculty name");
	    		final String facultyName = inputsForFaculty.nextLine();
	    		
	    		System.out.println("Enter Faculty dean");
	    		final String facultyDean = inputsForFaculty.nextLine();
	    		
	    		System.out.println("Enter Faculty building");
	    		final String facultyBuilding = inputsForFaculty.nextLine();
	    		
	    		try {
	    			PreparedStatement posted = con.prepareStatement("INSERT INTO faculty (faculty_name, dean, building) "
	    					+ "VALUES ('"+facultyName+"', '"+facultyDean+"', '"+facultyBuilding+"') ");
	    			 posted.executeUpdate();
	    		}
	    		catch(Exception e) {
		    		System.out.println(e);
		    		}
		    finally {System.out.println("Insert Completed");}
	    		
	    	}//end of faculty choice
	    	else if (choice.equals("department")) {
	    		Scanner inputForDepartment = new Scanner(System.in);
	    		
	    		System.out.println("Enter Department name");
	    		final String departmentName = inputForDepartment.nextLine();
	    		
	    		System.out.println("Enter faculty name");
	    		final String facultyName = inputForDepartment.nextLine();
	    		
	    		System.out.println("Enter campus name");
	    		final String campusName = inputForDepartment.nextLine();
	    		
	    		System.out.println("Enter curriculum name");
	    		final String curriculumName = inputForDepartment.nextLine();
	    		
	    		try {
	    			PreparedStatement posted = con.prepareStatement("INSERT INTO department (dept_name , faculty_faculty_name, campus_campus_name, curriculum_curr_id) "
	    					+ "VALUES ('"+departmentName+"', '"+facultyName+"', '"+campusName+"', '"+curriculumName+"' ) ");
	    			 posted.executeUpdate();
	    		}
	    		catch(Exception e) {
		    		System.out.println(e);
		    		}
		    finally {System.out.println("Insert Completed");}
	    		
	    	}//end of department choice
	    	else if(choice.equals("curriculum")) {
	    		Scanner inputForCurriculum = new Scanner(System.in);
	    		
	    		System.out.println("Enter curriculum name");
	    		final String curriculumName = inputForCurriculum.nextLine();
	    		
	    		System.out.println("Enter curriculum title");
	    		final String curriculumTitle = inputForCurriculum.nextLine();
	    		
	    		System.out.println("Enter curriculum level");
	    		final String curriculumLevel = inputForCurriculum.nextLine();
	    		
	    		System.out.println("Enter curriculum duration");
	    		final String curriculumduration = inputForCurriculum.nextLine();
	    		
	    		System.out.println("Enter department name");
	    		final String departmentName = inputForCurriculum.nextLine();
	    		
	    		try {
	    			PreparedStatement posted = con.prepareStatement("INSERT INTO curriculum (curr_id , title, level, duration, department_dept_name, department_dept_name1  ) "
	    					+ "VALUES ('"+curriculumName+"', '"+curriculumTitle+"', '"+curriculumLevel+"', '"+curriculumduration+"' , '"+departmentName+"' , '"+departmentName+"' ) ");
	    			 posted.executeUpdate();
	    		}
	    		catch(Exception e) {
		    		System.out.println(e);
		    		}
		    finally {System.out.println("Insert Completed");}
	    		


	    	}//end of choice curriculum
	    	else if (choice.equals("teacher")) {
	    		Scanner inputForTeacher = new Scanner(System.in);
	    		
	    		System.out.println("Enter teacher id");
	    		final String teacherId = inputForTeacher.nextLine();
	    		
	    		System.out.println("Enter teacher first name");
	    		final String teacherFirstName = inputForTeacher.nextLine();
	    		
	    		System.out.println("Enter teacher last name");
	    		final String teacherLastName = inputForTeacher.nextLine();
	    			    			    		
	    		System.out.println("Enter teacher title");
	    		final String teacherTitle = inputForTeacher.nextLine();
	    		
	    		System.out.println("Enter office number");
	    		final String teacherOfficeNumber = inputForTeacher.nextLine();
	    		
	    		System.out.println("Enter supervisor id");
	    		final String supervisorId = inputForTeacher.nextLine();
	    		
	    		System.out.println("Enter department name");
	    		final String departmentName = inputForTeacher.nextLine();
	    		
	    		try {
	    			PreparedStatement posted = con.prepareStatement("INSERT INTO teacher (department_dept_name  , teacher_id , first_name, last_name, title, office_number, supervisor_supervisor_id) "
	    					+ "VALUES ('"+departmentName+"', '"+teacherId+"', '"+teacherFirstName+"', '"+teacherLastName+"' , '"+teacherTitle+"' , '"+teacherOfficeNumber+"' , '"+supervisorId+"') ");
	    			 posted.executeUpdate();
	    		}
	    		catch(Exception e) {
		    		System.out.println(e);
		    		}
		    finally {System.out.println("Insert Completed");}
	    		
	    	}//end of choice teacher
	    	else if (choice.equals("supervisor")) {
	    		Scanner inputForSupervisor = new Scanner(System.in);
	    		
	    		System.out.println("Enter supervisor id");
	    		final String supervisorId = inputForSupervisor.nextLine();
	    		
	    		try {
	    			PreparedStatement posted = con.prepareStatement("INSERT INTO supervisor (supervisor_id) "
	    					+ "VALUES ( '"+supervisorId+"') ");
	    			 posted.executeUpdate();
	    		}
	    		catch(Exception e) {
		    		System.out.println(e);
		    		}
		    finally {System.out.println("Insert Completed");}
	    		
	    	}//end of choice supervisor
	    	else if (choice.equals("student")) {
	    		Scanner inputForStudent = new Scanner(System.in);
	    		
	    		System.out.println("Enter student id");
	    		final String studentId = inputForStudent.nextLine();
	    		
	    		System.out.println("Enter student first name");
	    		final String studentFirstName = inputForStudent.nextLine();
	    		
	    		System.out.println("Enter student last name");
	    		final String studentLastName = inputForStudent.nextLine();
	    		
	    		System.out.println("Enter student fathers name");
	    		final String studentFatherName = inputForStudent.nextLine();
	    		
	    		System.out.println("Enter student date of birth");
	    		final String studentDateOfBirth = inputForStudent.nextLine();
	    		
	    		System.out.println("Enter student registration date");
	    		final String studentRegistrationDate = inputForStudent.nextLine();
	    		
	    		System.out.println("Enter curriculum id");
	    		final String curriculumId = inputForStudent.nextLine();
	    		
	    		try {
	    			PreparedStatement posted = con.prepareStatement("INSERT INTO student (	student_id   , first_name	 , last_name, fathers_name, date_of_birth, registration_date, curriculum_curr_id ) "
	    					+ "VALUES ('"+studentId+"', '"+studentFirstName+"', '"+studentLastName+"', '"+studentFatherName+"' , '"+studentDateOfBirth+"' , '"+studentRegistrationDate+"' , '"+curriculumId+"') ");
	    			 posted.executeUpdate();
	    		}
	    		catch(Exception e) {
		    		System.out.println(e);
		    		}
		    finally {System.out.println("Insert Completed");}
	    		
	    		
	    	}//end of choice student
	    	else if(choice.equals("course")) {
	    		
	    		Scanner inputForcourse = new Scanner(System.in);
	    		
	    		System.out.println("Enter course id");
	    		final String courseId = inputForcourse.nextLine();
	    		
	    		System.out.println("Enter course name");
	    		final String courseName = inputForcourse.nextLine();
	    		
	    		System.out.println("Enter curriculum id");
	    		final String curriculumId = inputForcourse.nextLine();
	    		
	    		try {
	    			PreparedStatement posted = con.prepareStatement("INSERT INTO course (course_id, course_name, curriculum_curr_id) "
	    					+ "VALUES ('"+courseId+"', '"+courseName+"', '"+curriculumId+"') ");
	    			 posted.executeUpdate();
	    		}
	    		catch(Exception e) {
		    		System.out.println(e);
		    		}
		    finally {System.out.println("Insert Completed");}
	    		
	    		
		    		
		    		
	    		
	    		
	    			
	    		
	    		
	    	}//end of choice course
	    	else if(choice.equals("commission")) {
	    		
	    		Scanner inputForCommission = new Scanner(System.in);
	    		
	    		System.out.println("Enter commission name");
	    		final String commissionName = inputForCommission.nextLine();
	    		
	    		System.out.println("Enter faculty name");
	    		final String facultyName = inputForCommission.nextLine();
	    		
	    		try {
	    			PreparedStatement posted = con.prepareStatement("INSERT INTO commission (commission_name, faculty_faculty_name) "
	    					+ "VALUES ('"+commissionName+"', '"+facultyName+"') ");
	    			 posted.executeUpdate();
	    		}
	    		catch(Exception e) {
		    		System.out.println(e);
		    		}
		    finally {System.out.println("Insert Completed");}
	    	}
	    	else if (choice.equals("prerequisite")) {
	    		   			
	    			Scanner inputForPrerequisiteCourses = new Scanner(System.in);
	    			
	    			System.out.println("Enter prerequisite id");
		    		final String prerequisiteId = inputForPrerequisiteCourses.nextLine();
		    		
		    		System.out.println("Enter prerequisite name");
		    		final String prerequisiteName = inputForPrerequisiteCourses.nextLine();
		    		
		    		System.out.println("Enter main course id");
		    		final String prerequisite_courseId = inputForPrerequisiteCourses.nextLine();
	    			
		    		try {
		    			PreparedStatement posted = con.prepareStatement("INSERT INTO prerequisite_courses (prerequisite_id, prerequisite_name, course_course_id ) "
		    					+ "VALUES ('"+prerequisiteId+"', '"+prerequisiteName+"', '"+prerequisite_courseId+"') ");
		    			 posted.executeUpdate();
		    		}
		    		catch(Exception e) {
			    		System.out.println(e);
			    		}
			    finally {System.out.println("Insert Completed");}
	    	}//endd
	    	
	    	else if (choice.equals("student_course")) {	    			    			    			    			
	    			Scanner InputStudentCourse = new Scanner(System.in);
	    			
	    			System.out.println("Enter student id");
		    		final String studentId = InputStudentCourse.nextLine();
		    		
		    		System.out.println("Enter course id");
		    		final String courseStudentId = InputStudentCourse.nextLine();
		    		
		    		System.out.println("Enter year of attendance");
		    		final String year_of_attendance = InputStudentCourse.nextLine();
		    		
		    		System.out.println("Enter grade");
		    		final String  grade = InputStudentCourse.nextLine();	    			    		
		    		
		    		System.out.println("Enter registration date");
		    		final String registration_date = InputStudentCourse.nextLine();
		    		
		    		try {
		    			PreparedStatement posted = con.prepareStatement("INSERT INTO student_course (student_student_id , course_course_id , year_of_attendance, grade, registration_date) "
		    					+ "VALUES ('"+studentId+"', '"+courseStudentId+"', '"+year_of_attendance+"', '"+grade+"', '"+registration_date+"') ");
		    			 posted.executeUpdate();
		    		}
		    		catch(Exception e) {
			    		System.out.println(e);
			    		}
			    finally {System.out.println("Insert Completed");}
	    	}
	    	
	        
	        
	}//end post
	    public static void select_courses() throws Exception{
	    	try {
	    		Connection con = getConnection(); //connection to database	    		  	    	
		    	java.sql.Statement st = con.createStatement();
		    	java.sql.Statement st2 = con.createStatement();
		    	
		    	ResultSet res = st.executeQuery("SELECT * FROM course");
		        int flag = 1;
		        System.out.println("Courses :\n");
		        while (res.next()) {
		            String i = res.getString("course_id");
		            String s = res.getString("course_name");
		            System.out.println("course_id: " + "\t" + "course_name: ");
		            System.out.println(i + "\t\t"+ "-"+ s);
		            
		            ResultSet apaitoymena = st2.executeQuery("SELECT * FROM prerequisite_courses");
		            while (apaitoymena.next()) {
		            	String proapaitoymenoMathima = apaitoymena.getString("prerequisite_name");
		            	String idapaitoymeno = 	apaitoymena.getString("course_course_id");
		            	if(i.equals(idapaitoymeno)) {
		            		if(flag == 1) {
		            			System.out.println("prerequisite_name: ");
		            		}
		            		
		            		System.out.println( "\t\t"+ "-"+proapaitoymenoMathima);
		            		flag = flag+1;
		            	}
		            	
		            }//while apaitoymeno
		            flag = 1;		     
		        }
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    		}	    		    							 	
	    }//end select_courses
	    
	    public static void select_teacher() throws Exception{ 		
	    	
	    	try {
	    		Connection con = getConnection(); //connection to database	    		  	    	
		    	java.sql.Statement st = con.createStatement();
		    	ResultSet res = st.executeQuery("SELECT * FROM teacher ORDER BY department_dept_name");
		    	System.out.println("teachers name :");
		    	while(res.next()) {
		    		String fName = res.getString("first_name");
		    		String lName = res.getString("last_name");
		    		System.out.println("-"+fName +" "+lName );
		    	}
		    	
	    		
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    		}
	    }//end select_teacher
	    
	    
	    public static void select_supervisor() throws Exception{
	    	try {
	    		Connection con = getConnection(); //connection to database	    	
		    	
		    	java.sql.Statement st = con.createStatement();
		    	java.sql.Statement st2 = con.createStatement();
		    	
		    	int flag = 1; 
		    	
		    	ResultSet res = st.executeQuery("SELECT * FROM supervisor ORDER BY supervisor_id");
		    	System.out.println("supervisor id :");
		    	while(res.next()) {
		    		String superId = res.getString("supervisor_id");
		    		System.out.println("-"+superId+"\n");
		    		
		    		ResultSet apaitoymena = st2.executeQuery("SELECT * FROM teacher ORDER BY last_name");
		    		while(apaitoymena.next()) {
		    			String TeacherSuperId = apaitoymena.getString("supervisor_supervisor_id");
		    			String teacherName = apaitoymena.getString("first_name");
		    			if(superId.equals(TeacherSuperId)) {
		    				if(flag == 1) {
		            			System.out.println("teacher name : ");
		            		}
		    				System.out.println("-"+teacherName);
		            		flag = flag+1;	    				
		    			}
		    		}
		    		flag = flag+1;		    			    				
		    	}	    	
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    		}	    		 	
	    }
	    
	    public static void passed_course(String student, String course) throws Exception{
	    	try {	    		
    		Connection con = getConnection(); //connection to database	    	
		    	
		    	java.sql.Statement st = con.createStatement();
		    	java.sql.Statement st1 = con.createStatement();
		    	java.sql.Statement st2 = con.createStatement();
		    	
		    	int flag = 0; 
		    	
		    	ResultSet courseInfo = st.executeQuery("SELECT * FROM course WHERE course_id ='"+ course +"'");
		    	ResultSet StudentInfo = st1.executeQuery("SELECT * FROM  student WHERE student_id ='"+ student +"'");
		    	ResultSet StudentCourseInfo = st2.executeQuery("SELECT * FROM  student_course WHERE student_student_id  = '"+ student +"' AND course_course_id = '"+ course +"' ");
		    	
		    	while(courseInfo.next()) {
		    		String courseName = courseInfo.getString("course_name");
		    		System.out.println("course name : "+courseName+"\n");
		    	}
		    	while(StudentCourseInfo.next()) {
		    		String grade = StudentCourseInfo.getString("grade");
		    		System.out.println("grade : "+grade+"\n");
		    		int gradeInt = Integer.parseInt(grade); 
		    		if (gradeInt >= 5) {
		    			flag = 1;
		    		}
		    		
		    	}
		    	if(flag == 1) {
		    		System.out.println("Course passed");
		    	}
		    	else{
		    		System.out.println("Course failed");
		    	}
		    			    			    
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    	
	    	
	    }//
	    
	    public static void over_Due(String curriculum) throws Exception{
	    	try {
	    		Date d = new Date();  
    	        int year=d.getYear();  
    	        int currentYear=year+1900;
    	        
	    		Connection con = getConnection(); //connection to database	   
	    		java.sql.Statement st = con.createStatement();
	    		java.sql.Statement st1 = con.createStatement();
	    		java.sql.Statement st2 = con.createStatement();
	    		java.sql.Statement st3 = con.createStatement();
	    		
	    		ResultSet studentInfo = st.executeQuery("SELECT * FROM student  WHERE curriculum_curr_id  ='"+ curriculum +"'");
	    		ResultSet curriculumInfo = st1.executeQuery("SELECT * FROM  curriculum  WHERE curr_id  ='"+ curriculum +"'");
	    		
	    		
		    	int intd = 2000;
		    	while(curriculumInfo.next()) {
		    		String duration = curriculumInfo.getString("duration");
		    		 intd = Integer.parseInt(duration);
		    	}
		    	
		    	
	    		while(studentInfo.next()) {
	    			Date register = studentInfo.getDate("registration_date");
	    			//String register = studentInfo.getString("registration_date");
		    		
		    		String StudentName = studentInfo.getString("first_name");
		    		String StudentId = studentInfo.getString("student_id");
	                
		    		int f = register.getYear();
	                if ((year - f ) > (intd + 2)){
	                	System.out.println(StudentName+ " has been exceed the permissible limit");
	                	 st2.execute("Delete  FROM student WHERE student_id = '"+ StudentId +"'");
	                	 System.out.println("successful deletion");
	                	
	                }
	                
	               	               	                		                	                
	    		}	    			    			         
	    		
	    		
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    	}
	    
	 }

	    
	    public static Connection getConnection() throws Exception{
	         
	         Connection conn = null;
	         String url = "jdbc:mysql://localhost:3306/";
	         String dbName = "university";
	         String driver = "com.mysql.jdbc.Driver";
	         String userName = "root"; 
	         String password = "";

	         try{
	             Class.forName(driver).newInstance();
	             conn = DriverManager.getConnection(url+dbName,userName,password);
	            
	         }catch(Exception e) {
	             e.printStackTrace();
	         }
	        return conn; 
	    }
 
    
    
}

