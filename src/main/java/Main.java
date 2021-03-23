import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.diary.backend.EntryController;
import com.sda.diary.backend.EntryRepository;
import com.sda.diary.backend.EntryService;
import com.sda.diary.backend.TimeClient;
import com.sda.diary.frontend.InputValidator;
import com.sda.diary.frontend.UserInterface;

public class Main {
    public static void main(String[] args) {
            EntryRepository entryRepository = new EntryRepository();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            TimeClient timeClient = new TimeClient(objectMapper);
            EntryService entryService = new EntryService(entryRepository, timeClient);
            EntryController entryController = new EntryController(entryService);
            InputValidator inputValidator = new InputValidator();
            UserInterface userInterface = new UserInterface(entryController,inputValidator);
            userInterface.runApp();

    }
}
