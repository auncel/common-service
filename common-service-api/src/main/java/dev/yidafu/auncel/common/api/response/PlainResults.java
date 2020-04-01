package dev.yidafu.auncel.common.api.response;

public class PlainResults {

  public static <T> PlainResult<T> success(T data, String msg) {
    PlainResult result = new PlainResult(true, data, 1, msg);
    return result;
  }

  public static PlainResult error(Integer code, String msg) {
      PlainResult result = new PlainResult();
      result.setCode(code);
      result.setMsg(msg);
      result.setSuccess(false);
      return result;
  }
}
