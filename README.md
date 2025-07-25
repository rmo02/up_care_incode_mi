
# TV Mirante: Up Care

Projeto Up Care desenvolvido pela equipe do INCODE Tech School para a TV Mirante.

## Critérios de Conclusão

### Model
✅ Completo quando:
- Anotações `@Entity`, `@Getter` e `@Setter` estiverem presentes
- Relacionamentos criados com `@ManyToOne` e `@JoinColumn`
- Campos devidamente validados com as anotações do Validation

### Repository
✅ Completo quando:
- Interface criada com anotação `@Repository` presente
- Interface extendendo `JPARepository` corretamente

### Service
✅ Completo quando:
- Anotação `@Service` estiver presente
- Criados os métodos de: 
    - Salvar anotado com `@Valid` e retornando a entidade salva
    - Buscar todos retornando um `List<Entity>`
    - Buscar por ID retornando um `Entity`
    - Atualizar recebendo o ID da entidade e as atualizações, retornando a entidade atualizada
    - Excluir recebendo o ID da entidade e não retornando nada

### Controller
✅ Completo quando:
- Anotação `@RestController` e `@RequestMapping` estiver presentes
- Rota definida com o nome do recurso (entidade) no plural
- Criados os métodos de: 
    - Salvar anotado com `@PostMapping`,  `@RequestBody` e `@Valid` e retornando o status `201 (CREATED)`
    - Buscar todos anotado com `@GetMapping` e retornando o status `200 (OK)`
    - Buscar por ID anotado com `@GetMapping("{idEntity}")` e `@PathVariable` e retornando o status `200 (ok)`
    - Atualizar anotado com `@PutMapping`, `@PathVariable`, `@RequestBody` e `@Valid` e retornando o status `204 (NO_CONTENT)`
    - Excluir anotado com `@DeleteMapping("{idEntity}")` e `@PathVariable` e retornando o status `204 (NO_CONTENT)`
- Todos os endpoints retornarem `ResponseEntity<T>`

### Mapper
✅ Completo quando:
- Criados os métodos de:
    - Mapeamento de `Request` para `Entity`
    - Mapeamento de `Entity` para `Response`
    - Mapeamento de `List<Entity>` para `Response`

### Request
✅ Completo quando:
- Todos os campos da entidade original estiverem presentes
- Os campos estiverem com as anotações do Validation

### Response
✅ Completo quando:
- Todos os campos da entidade original estiverem presentes


## Divisão de Responsabilidades
|Nome                 |Responsável    |Model|Repository| Service |Controller|Request|Response|Mapper|
|---------------------|---------------|-----|----------|---------|--------|----|--------|----|
|**Antena**           |Adriano        |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Parabolica**       |Adriano        |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Receptor**         |Adriano        |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Transmissor**      |Adriano        |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Quadro**           |Arthur e Khalil|✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Nobreak**          |Arthur e Khalil|✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Switch**           |Arthur e Khalil|✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Disjuntor**        |Arthur e Khalil|✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**DPS**              |Arthur e Khalil|✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Equipamento**      |David          |✅  |✅        | ✅*1     |✅*1     |✅  |✅      |✅ |
|**Estacao**          |David          |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Tarefa**           |David          |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**TarefaEquipamento**|David          |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Manutencao**       |Elenylson      |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Usuario**          |Elenylson      |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Empresa**          |Elenylson      |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**ArCondicionado**   |Rafael         |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Cabo**             |Rafael         |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Telemetria**       |Rafael         |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Combinador**       |Rafael         |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Exautor**          |Rafael         |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |
|**Torre**            |Rafael         |✅  |✅        | ✅       |✅       |✅  |✅      |✅ |

- ***1**: Por equanto, os equipamentos são salvos, alterados e excluídos por suas especializações.
