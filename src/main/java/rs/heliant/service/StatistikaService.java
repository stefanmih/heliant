package rs.heliant.service;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import rs.heliant.entity.FormularDO;
import rs.heliant.entity.StatistikaDO;
import rs.heliant.repository.StatistikaRepository;

import java.util.Calendar;
import java.util.Date;

@Service
public class StatistikaService {

    private final StatistikaRepository repository;

    private final FormularService service;

    private final TaskScheduler taskScheduler;

    public StatistikaService(StatistikaRepository repository, FormularService service, TaskScheduler taskScheduler) {
        this.repository = repository;
        this.service = service;
        this.taskScheduler = taskScheduler;
        schedule();
    }

    private void schedule() {
        taskScheduler.schedule(() -> {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            Date start = cal.getTime();
            Date end = new Date();
            int count = service.countFormularPopunjen().stream().filter(
                    e->e.getVremePoslednjeIzmeme().after(start) && e.getVremePoslednjeIzmeme().before(end))
                    .toList()
                    .size();
            StatistikaDO statistika = new StatistikaDO();
            statistika.setId(repository.findAll().size()+1);
            statistika.setDatum(new Date());
            statistika.setBrojPopunjenihFormulara(count);
            repository.save(statistika);
        }, new CronTrigger("0 0 0 * * *"));
    }


}
