package rest.api.book.restbookapp.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rest.api.book.restbookapp.helper.FileUpload;

@RestController
public class FileUploaderController {

    @Autowired
    private FileUpload fileUpload;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("Indira")MultipartFile file){


        boolean check=fileUpload.uploadFile(file);

        if (check){
            return ResponseEntity.ok("File is successfully uploaded");
        }

        return ResponseEntity.ok("working");
    }
}
