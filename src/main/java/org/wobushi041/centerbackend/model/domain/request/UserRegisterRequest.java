package org.wobushi041.centerbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 041
 * @createtime 2026/4/5
 * 封装专门用来接收请求参数的对象
 * 作用于controller层，接收前端传递过来的参数
 */
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = 3191241716373120793L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;
    private String planetCode;
}
// 如果不显式定义这个值会发生什么？
// 如果你没有在类中显式声明 serialVersionUID，Java 的序列化运行时会根据类的内部细节（如类名、接口名、方法和属性等）自动通过哈希算法生成一个默认的 serialVersionUID。
// 风险在于：一旦类发生了修改（例如增加了一个方法、修改了字段类型），自动生成的 UID 就会发生变化。这会导致之前序列化的数据无法再被反序列化（即使改动很小且逻辑兼容）。
