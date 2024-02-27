package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String logradouro;
    private String cep;
    private String complemento;
    private String numero;
    private String uf;
    private String cidade;
    private String telefone;
    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dadosCadastroPaciente) {
        this.nome = dadosCadastroPaciente.nome();;
        this.email = dadosCadastroPaciente.email();
        this.cpf = dadosCadastroPaciente.cpf();
    }
}
