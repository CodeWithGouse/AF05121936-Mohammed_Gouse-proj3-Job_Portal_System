import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
        	System.out.println("1. Register");
        	System.out.println("2. Login");
        	System.out.println("3. Exit");
        	System.out.print("Choose an option: ");
            int ch=sc.nextInt();
            switch(ch){
                case 1->RegisterUser.execute(sc);
                case 2->{
                    int uid=LoginUser.login(sc);
                    if(uid!=-1){
                    	System.out.println("1. View Jobs");
                    	System.out.println("2. Search Jobs");
                    	System.out.println("3. Apply for Job");
                    	System.out.println("4. View Applications");
                    	System.out.println("5. Post Job");
                    	System.out.println("6. Delete Job");
                    	System.out.print("Choose an option: ");
                        int op=sc.nextInt();
                        switch(op){
                            case 1->ViewJobs.execute();
                            case 2->SearchJobs.execute(sc);
                            case 3->ApplyJob.execute(sc,uid);
                            case 4->ViewApplications.execute(uid);
                            case 5->PostJob.execute(sc);
                            case 6->DeleteJob.execute(sc);
                        }
                    }
                }
                case 3->System.exit(0);
            }
        }
    }
}
