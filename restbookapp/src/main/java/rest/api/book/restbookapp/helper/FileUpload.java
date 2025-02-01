package rest.api.book.restbookapp.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;

@Component
public class FileUpload {

    public final String
            uploadDirectory="E:\\SpringBoot\\BootProject\\restbookapp\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile file){

        boolean f=false;

        try{
            InputStream is=file.getInputStream();
            byte data[]=new byte[is.available()];

            is.read(data);

            FileOutputStream fos=new FileOutputStream(uploadDirectory+"\\"+file.getOriginalFilename());
            fos.write(data);

            fos.close();

            f=true;


        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
