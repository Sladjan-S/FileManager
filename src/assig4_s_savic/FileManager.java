
package assig4_s_savic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;



public class FileManager
{
    
     
    void list(File f)
    {
    
                            if (f.exists() && f.isDirectory())
                            {
                                File[] files = f.listFiles();
                                for (int i = 0; i < files.length; i++)
                                {
                                    System.out.println(files[i].getName()); 
                                }
                            }
                            else
                            {
                                System.out.println("Directory or file does not exist!");
                            }
    }
    
    void info(File f)
    {
      
                            if (f.exists())
                            {
                                System.out.println("Name: "+f.getName());
                                System.out.println("Path:"+f.getPath());
                                System.out.println("File size: "+f.length()+" bytes");
                                
                                Instant instant = Instant.ofEpochMilli(f.lastModified());
                                LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd. MMMM yyyy. HH:mm:ss");
                                
                                System.out.println("Last modified: "+dateTime.format(dtf));
                            }
    }
    
    void createDir(File f)
    {
     
                            
                            if (!f.exists())
                            {
                                f.mkdir();
                                System.out.println("The directory "+f.getName()+" sucessfully created!");
                               
                            }
                            else
                            {
                                System.out.println("Directory with this name already exists!");
                            }
    }
    
    void rename(File newName,File oldName)
    {  
                        if (!oldName.exists())
                        {
                            System.out.println("File/Directory does not exist");
                            return;
                        }
                        if (newName.exists())
                        {
                            System.out.println("File/Directory with this name already exists!");
                            return;
                        }
                        if (oldName.renameTo(newName))
                        {
                            System.out.println("File or Directory renamed succesfully");
                        }
                        else{
                            System.out.println("Renaming failed!");
                        }
    }
    
    void copyDir(File src,File dest)
    {
    
           if (src.isDirectory())
        {
            if (!dest.exists())
            {
                dest.mkdir();
                
                String fs[] = src.list();
                for (int i = 0; i < fs.length; i++)
                {
                    copyDir(new File(src,fs[i]),new File(dest,fs[i]));
                }
            }
        }
                        else
                        {
                           try(FileInputStream inStream = new FileInputStream(src);
                                FileOutputStream outStream = new FileOutputStream(dest);)
                        {
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = inStream.read(buffer))>0)
                            {                                
                                outStream.write(buffer,0,length);
                            }
                            System.out.println("Copying sucess!");
                            inStream.close();
                            outStream.close();
                        }
                        catch (IOException e)
                        {
                            System.out.println(e);
                        }
                        }            
    }
    
    void move(File source,File dest)
    {
    
                        if (!dest.exists())
                        {
                            dest.mkdirs();
                        }
                        if (source.exists() && source.isDirectory())
                        {
                            File[]listOfFiles = source.listFiles();
                            if (listOfFiles !=null)
                            {
                                for (File listed : listOfFiles)
                                {
                                    listed.renameTo(new File(dest+"\\"+listed.getName()));
                                }
                                source.delete();
                            }
                        }
                        else
                        {
                            System.out.println(source+" does not exist");
                        }     
    }
    
    void deleteDir(File f)
    {
                        File[]files = f.listFiles();
                        if (files != null)
        {
            for (File file : files)
            {
                if (file.isDirectory())
                {
                    deleteDir(f);
                }
                else
                {
                file.delete();
                }
            }
        }
                        if (f.exists())
                        {
                            f.delete();
                            System.out.println("File deleted!");
                        }
                        else
                        {
                            System.out.println("Can not delete "+f.getName()+",it does not exist");
                        }
    }
    
    void quit()
    {
       System.out.println("Application closed");
    }
}
