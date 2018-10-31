package cn.j.sbdemo.xzh.http;

/**
 * http响应类
 *
 * @author xzh
 * @date 2018/3/16 下午6:55
 */
public class XzhResponse {

    private String body;
    private int status;

    public XzhResponse() {
        status = 0;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "XzhResponse{"
                + "body='" + body + '\''
                + ", status=" + status + '}';
    }
}
