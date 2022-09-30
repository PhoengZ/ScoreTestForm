import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.security.cert.CertPathValidatorException;
import java.io.File;
import java.io.PrintWriter;

public class ScoreTest {
    public static void main(String[] args) {
        //CSV File
        String file = "src\\Sleep1.csv";
        String filepath = "src\\ResultScore.csv";
        
        System.out.println("Starting write user .csv file : "+ filepath);
        

        System.out.println("start read user.csv file");
        readCsv(file);
    }class Person{
        public static List <String>Score = new ArrayList<>();
        public static List<String> Grade = new ArrayList<>();
        public static int g = 0;
        public static int f = 0;
        public static int p = -1;
        public static int o = 0  ;
        public static float p1;
        public static float g1;
        public static float f1;
        public static int k;

    }
    
    public static void readCsv(String file){
        BufferedReader reader = null;
        
        try {
            int l = 1;
            String j;
            String line = "";
            
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                ScoreTest.Person.k = 0;
                String [] row = line.split(",");
                for(int i = 0; i < 19; i++ ){
                    if(i == 6 || i== 7 || i == 8 ){
                        if(row[i].contains("มากที่สุด")){
                            ScoreTest.Person.k += 1;
                        }else if (row[i].contains("มาก")){
                            ScoreTest.Person.k += 2;
                        }else if(row[i].contains("เล็กน้อย")){
                            ScoreTest.Person.k += 3;
                        }else if(row[i].contains("ไม่เลย")){
                            ScoreTest.Person.k  += 4;
                        }else{
                            ScoreTest.Person.k += 0;
                        }
                    }else{
                        if(row[i].contains("มากที่สุด")){
                            ScoreTest.Person.k +=4; 
                        }else if(row[i].contains("มาก")){
                            ScoreTest.Person.k += 3;
                        }else if(row[i].contains("เล็กน้อย")){
                            ScoreTest.Person.k += 2;
                        }else if(row[i].contains("ไม่เลย")){
                            ScoreTest.Person.k  += 1;
                        }else{
                            ScoreTest.Person.k += 0;
                        }
                    }  
                }
                if(ScoreTest.Person.k <= 43){
                    ScoreTest.Person.Grade.add("Poor");
                }else if(ScoreTest.Person.k>=51){
                    ScoreTest.Person.Grade.add("Good");
                }else{
                    ScoreTest.Person.Grade.add("Fair");
                }

                j = String.valueOf(ScoreTest.Person.k);
                ScoreTest.Person.Score.add(j);
                System.out.print("User "+ l + " is " + " ");
                System.out.println(ScoreTest.Person.k);
                
                l ++;
                allsum();
            }
            ScoreTest.Person.p1 =  ScoreTest.Person.p * 100 /ScoreTest.Person.o;
            ScoreTest.Person.g1 =  ScoreTest.Person.g * 100 /ScoreTest.Person.o;
            ScoreTest.Person.f1 =  ScoreTest.Person.f * 100 /ScoreTest.Person.o;
            System.out.println(ScoreTest.Person.p1);
            
            writeCsv();
            System.out.println("fins");
            System.out.println(ScoreTest.Person.g);
            System.out.println(ScoreTest.Person.Grade);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public static void writeCsv(){
        String filepath = "src\\ResultScore.csv";
        
        
        try{
            PrintWriter pw = new PrintWriter(new File(filepath));
            StringBuilder sb = new StringBuilder();

            sb.append(ScoreTest.Person.Grade);
            sb.append("\n");
            sb.append(ScoreTest.Person.Score);
            sb.append("\n");
            sb.append("Good : ");
            sb.append(ScoreTest.Person.g);
            sb.append(" ");
            sb.append(ScoreTest.Person.g1);
            sb.append("%");
            sb.append("\n");
            sb.append("Fair : ");
            sb.append(ScoreTest.Person.f);
            sb.append(" ");
            sb.append(ScoreTest.Person.f1);
            sb.append("%");
            sb.append("\n");
            sb.append("Poor : ");
            sb.append(ScoreTest.Person.p);
            sb.append(" ");
            sb.append(ScoreTest.Person.p1);
            sb.append("%");
            pw.write(sb.toString());
            pw.close();
            
        }catch (Exception e){
            //ToDo:handle exception
        }

    
    }
    public static void allsum(){
        if(ScoreTest.Person.k >=51){
            ScoreTest.Person.g ++;
            
        }else if (ScoreTest.Person.k <= 43){
            ScoreTest.Person.p ++;
            
        }else  {
            ScoreTest.Person.f ++;  
        }
        ScoreTest.Person.o = ScoreTest.Person.g + ScoreTest.Person.f + ScoreTest.Person.p;
        }

    
}


    
