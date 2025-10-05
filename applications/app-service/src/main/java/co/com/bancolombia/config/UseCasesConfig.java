package co.com.bancolombia.config;

import co.com.bancolombia.infrastructure.drivenadapters.jparepository.repositories.InMemoryTodoRepository;
import co.com.bancolombia.model.todo.gateways.TodoRepository;
import co.com.bancolombia.usecase.todo.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

        @Bean
        public TodoRepository todoRepository() {

                return new InMemoryTodoRepository();
        }

        @Bean
        public CreateTodoUseCase createTodoUseCase(TodoRepository repository) {
                return new CreateTodoUseCase(repository);
        }

        @Bean
        public GetTodoByIdUseCase getTodoByIdUseCase(TodoRepository repository) {
                return new GetTodoByIdUseCase(repository);
        }

        @Bean
        public UpdateTodoUseCase updateTodoUseCase(TodoRepository repository) {
                return new UpdateTodoUseCase(repository);
        }

        @Bean
        public DeleteTodoUseCase deleteTodoUseCase(TodoRepository repository) {
                return new DeleteTodoUseCase(repository);
        }

        @Bean
        public ListTodosUseCase listTodosUseCase(TodoRepository repository) {
                return new ListTodosUseCase(repository);
        }
}
