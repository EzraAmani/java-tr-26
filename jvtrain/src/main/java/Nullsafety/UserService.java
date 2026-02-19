package Nullsafety;

import java.util.Optional;

// Example using JSpecify
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked // By default, everything in this class is NonNull
public class UserService {

    @Nullable // Explicitly override the default for this method
    public String findNicknameOrNull(String userId) {
        if ("user123".equals(userId)) {
            return "CoolUser";
        } else {
            return null; // This is now an explicit, documented possibility
        }
    }

    public void processNickname(String nickname) {
        // No null check needed here? Wrong! The input 'nickname' is NonNull by default.
        // NullAway or your IDE would flag a compile error if you passed a null
        // argument.
        System.out.println("Processed: " + nickname);
    }

}
