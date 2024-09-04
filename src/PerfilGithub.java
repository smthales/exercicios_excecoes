public class PerfilGithub {
    private String login;
    private int id;


    public PerfilGithub(String login, int id) {

        if(login.equals("null")) {
            throw new ErroConsultaGitHubException("O Id fornecido não existe na base de dados do Github.");
        }

        this.login = login;
        this.id = id;
    }

    public PerfilGithub(PerfilGithubIntermediario i) {
        if(i.id() == 0) {
            throw new ErroConsultaGitHubException("O Id fornecido não existe na base de dados do Github.");
        }

        this.login = i.login();
        this.id = i.id();
    }

    public String getLogin() {
        return this.login;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return String.format("Login: %s | Id: %d", this.login, this.id);
    }
}
