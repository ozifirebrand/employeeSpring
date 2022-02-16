package africa.semicolon.employeeProgram.services.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
@ContextConfiguration
@SpringBootTest
@Slf4j
class CloudinaryServiceImplTest {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private CloudinaryService cloudinaryService;


    @Test
    public void upload() throws IOException {
        File file = new File("src/test/resources/Ozi_profile.jpg");
        assertThat(file).isNotNull();
        Map<?, ?> uploadedResult = cloudinaryService.upload(Files.readAllBytes(file.toPath()), ObjectUtils.asMap());
        assertThat(uploadedResult.get("url")).isNotNull();
        log.info("Image url is {}", uploadedResult.get("url"));
    }
}