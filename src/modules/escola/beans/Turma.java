package modules.escola.beans;

import modules.escola.dao.AlunoDao;
import modules.escola.dao.TurmaDao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table
public class Turma  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10, unique = true, nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nome;

    @ManyToOne(optional = false)
	private TipoTurma tipo;

    @ManyToOne
    private Aluno representante;

    @ManyToOne
    private Professor professor;

    @OneToMany(mappedBy="turma")
    private List<Aluno> alunos;

    public Turma() {
    }

    public Turma(String codigo, String nome) {
        setCodigo(codigo);
        setNome(nome);
    }

    public Turma(String codigo, String nome, Aluno representante){
        setCodigo(codigo);
        setNome(nome);
        setRepresentante(representante);
    }

    public Turma(String codigo, String nome, Aluno representante, Professor professor){
        setCodigo(codigo);
        setNome(nome);
        setRepresentante(representante);
        setProfessor(professor);
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

	public TipoTurma getTipo() {
		return tipo;
	}

	public void setTipo(TipoTurma tipo) {
		this.tipo = tipo;
	}

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos() {
        return AlunoDao.listByTurmaId(this.getId());
    }

    public void setRepresentante(Aluno representante) {
        this.representante = representante;
    }

    public Aluno getRepresentante() {
        return representante;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public long getTotalAlunos() {
        return TurmaDao.getTotalAlunosPara(this);
    }

    public void fillFromForm(Turma turmaForm) {
        this.setNome(turmaForm.getNome());
        this.setCodigo(turmaForm.getCodigo());
        this.setTipo(turmaForm.getTipo());
        this.setRepresentante(turmaForm.getRepresentante());
        this.setProfessor(turmaForm.getProfessor());
    }
}
