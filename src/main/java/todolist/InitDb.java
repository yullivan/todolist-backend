package todolist;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import todolist.list.TodoList;
import todolist.task.Task;

@Component
public class InitDb {

    private final InitService initService;

    public InitDb(InitService initService) {
        this.initService = initService;
    }

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    static class InitService {
        private final EntityManager em;

        InitService(EntityManager em) {
            this.em = em;
        }

        public void dbInit1() {
            TodoList 리스트 = new TodoList("구매 목록");
            em.persist(리스트);

            Task 할일 = new Task("전자레인지", 리스트);
            em.persist(할일);
        }

        public void dbInit2() {
            TodoList 리스트 = new TodoList("개발");
            em.persist(리스트);

            Task 할일1 = new Task("자바 클래스 복습하기", 리스트);
            em.persist(할일1);

            Task 할일2 = new Task("HTTP, URL 복습하기", 리스트);
            em.persist(할일2);
        }
    }
}
