package com.example.file_upload;

import org.springframework.stereotype.Service;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;

@Service
public class FileUploadService {

    private static final Logger logger = LoggerFactory.getLogger("MyService.class");
    @Autowired
    private  FileUploadRepository fileUploadRepository;

    public int saveImage(FileUploadModel fileUploadModel) {
        try {
            fileUploadRepository.save(fileUploadModel);
            return 1;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return 0;
        }
    }

    public FileUploadModel getImages(Long id) {
        Optional findById = fileUploadRepository.findById(id);
        if (findById.isPresent()) {
            FileUploadModel getImageDetails = (FileUploadModel) findById.get();
            logger.info("id= " + getImageDetails.getId() + " name= " + getImageDetails.getName());
            return getImageDetails;
        } else {
            return null;
        }
    }
}
