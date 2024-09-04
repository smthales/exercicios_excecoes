public class ErroConsultaGitHubException extends RuntimeException{
    private String message;
    public ErroConsultaGitHubException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
}
