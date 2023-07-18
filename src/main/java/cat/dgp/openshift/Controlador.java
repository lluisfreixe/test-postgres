package cat.dgp.openshift;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.dgp.openshift.Individuo;

@Controller
public class Controlador {
	
	@Autowired
    public Parametres bean;
 
    @RequestMapping("urlbbdd")
    String getUrl() {
        return bean.getUrl();
    }
	
	@Autowired
	private IndividuoDao individuoDao;
	
	String appName = "test-postgres";

	@GetMapping("/entrada")
	public String entrada(Model model) {
		
		//Parametres urlbbdd = new Parametres();
		String url = bean.getUrl();
		
		String data = obtenirData();
		String hora = obtenirHora();
		String capacitat = "1000";
		model.addAttribute("appName", appName);
		model.addAttribute("capacitat", capacitat);
		model.addAttribute("data", data);
		model.addAttribute("hora", hora);
		model.addAttribute("urlbbdd", url);

		esborrarDades();
		inserirDades();
		Iterable<Individuo> individuos = individuoDao.findAll();
		model.addAttribute("individuos", individuos);
	    return "primera";
	  }
	
	private String obtenirData () {
		Date date = new Date();
		DateFormat formatData = DateFormat.getDateInstance(DateFormat.SHORT);
		String data = formatData.format(date);
		return data;
	}

	private String obtenirHora () {
		
		Date date = new Date();
		DateFormat formatHora = new SimpleDateFormat("HH:mm:ss");
		String hora = formatHora.format(date);
		
		return hora;
	}

	private boolean esborrarDades () {
		boolean correcte = true;
		individuoDao.deleteIndividuoAll();
		return correcte;
	}

	private boolean inserirDades () {
		boolean correcte = true;
		for (int i=1; i <= 1000; i++) {
			Individuo individuo = new Individuo();
			individuo.setId_individuo(i);
			individuo.setNombre("Nom"+i);
			individuo.setApellido("Cognom"+i);
			individuo.setEdad(i);
			individuo.setTelefono("1111"+i);
			individuo.setCorreo(i+"correu@correu.cat");
			individuoDao.insertIndividuo(individuo);
		}
		System.out.println("metode inserirDades executat.");
		return correcte;
	}

}
