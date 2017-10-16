
package assig4_s_savic;

import java.io.File;
import java.util.Scanner;


public class Assig4_S_Savic
{

  
    public static void main(String[] args)
    {
        label:
        while (true)
        {            
            System.out.println("Enter one of the commands(LIST,INFO,CREATE_DIR,RENAME,COPY,MOVE,DELETE or QUIT):");
            try
            {
                
                FileManager fm = new FileManager();
                Scanner s = new Scanner(System.in);
               
                
                String cmd = s.nextLine();
                
                
                switch(cmd)
                {
                    case "list":
                    {     
                        System.out.println("Enter directory path:");
    
                            File f = new File(s.nextLine());
                            fm.list(f);
                            break;
                    }
                    
                    case "info":
                    {     
                        System.out.println("Enter file/directory path:");
                            File f = new File(s.nextLine());
                          fm.info(f);
                            break;
                    }
                    
                    case "create_dir":
                    {      
                        System.out.println("Enter path and name of directory: ");
                            File f = new File(s.nextLine());
                           fm.createDir(f);
                           break;
                    }
                    
                    case "rename":
                    {
                        System.out.println("Enter path of directory/file name to be renamed: ");
                        File oldName = new File(s.nextLine());
                        System.out.println("Enter path of directory/file newly named: ");
                        File newName = new File(s.nextLine());
                      fm.rename(newName,oldName);
                         break;
                    }
                    
                    case "copy":
                    {
                         System.out.println("Enter source file/dir to be copied: ");
                        File src = new File(s.nextLine());
                        System.out.println("Enter destionation for file/dir to be copied to: ");
                        File dest = new File(s.nextLine());
                       fm.copyDir(src,dest);
                   break;
                    }
                    
                    case "move":
                    {
                         System.out.println("Enter path of file/directory to be moved: ");
                        File source = new File(s.nextLine());
                        System.out.println("Enter moving destination: ");
                        File dest = new File(s.nextLine());
                        
                       fm.move(source,dest);
                     break;
                    }
                    
                    case "delete":
                    {
                         System.out.println("Enter file/directory path to be deleted: ");
                        File f = new File(s.nextLine());
                       fm.deleteDir(f);
                    break;
                    }
                    
                    case"quit":
                    {
                    fm.quit();
                    break label;
                    }
                    
                    default:
                    {
                        System.out.println("Command not recognized!\nEnter one of listed commands!");
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
                
            }
        }
    }
    
}
