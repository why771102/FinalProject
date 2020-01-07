import com.c.model.HallBean;
import com.c.service.HallService;
import com.c.service.impl.HallServiceImpl;

public class Main {

	public static void main(String[] args) {
		HallBean hb = new HallBean("A", 300, 1500, 0);
		HallService hs = new HallServiceImpl();
		hs.insertHall(hb);
	}

}
