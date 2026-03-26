package resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 统一接口返回格式
 * @param <T> 数据泛型
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {
    private String code; // 返回码
    private String message; // 描述信息
    private T data; // 业务数据
    private long timestamp; // 请求时间戳

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    // 成功返回
    public static <T> ResultData<T> success(T data) {
        ResultData<T> result = new ResultData<>();
        result.setCode(ReturnCodeEnum.RC200.getCode());
        result.setMessage(ReturnCodeEnum.RC200.getMessage());
        result.setData(data);
        return result;
    }

    // 失败返回
    public static <T> ResultData<T> fail(String code, String message) {
        ResultData<T> result = new ResultData<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}