package africa.semicolon.employeeProgram.services.cloud;

import java.util.Map;

public interface CloudinaryService {
    Map<?, ?> upload(byte[] bytes, Map<?, ?> params);
}
