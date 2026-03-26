package resp;

import lombok.Getter;

import java.util.Arrays;

/**
 * 统一返回码枚举
 */
@Getter
public enum ReturnCodeEnum {
    RC999("999", "操作失败"),
    RC200("200", "success"),
    RC403("403", "无访问权限"),
    RC404("404", "资源不存在"),
    RC500("500", "系统异常,请稍后重试"),
    BUSINESS_ERROR("1004", "业务逻辑异常");

    private final String code;
    private final String message;

    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // 根据code获取枚举
    public static ReturnCodeEnum getReturnCodeEnumV2(String code) {
        return Arrays.stream(ReturnCodeEnum.values())
                .filter(x -> x.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}