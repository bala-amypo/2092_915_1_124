import java.util.List;
import com.example.demo.entity.DiversityTarget;

public interface DiversityTargetService {

    DiversityTarget createTarget(DiversityTarget target);

    List<DiversityTarget> getActiveTargets();   // ✅ ADD THIS
}
