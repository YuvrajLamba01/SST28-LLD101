import java.util.*;

public class OnboardingService {
    private final StudentRepository db;
    private final StudentParser parser;
    private final StudentValidator validator;
    private final MessageLogger logger; 

    public OnboardingService(StudentRepository db) { 
        this.db = db; 
        this.parser = new StudentParser();
        this.validator = new StudentValidator();
        this.logger = new MessageLogger(); 
    }

    public void registerFromRawInput(String raw) {
        
        logger.logInput(raw);

        Map<String, String> data = parser.parse(raw);
        List<String> errors = validator.validate(data);

        if (!errors.isEmpty()) {
        
            logger.logErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(
            id, 
            data.get("name"), 
            data.get("email"), 
            data.get("phone"), 
            data.get("program")
        );

        db.save(rec);

        logger.logSuccess(id, db.count(), rec);
    }
}
}
