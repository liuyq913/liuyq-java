package com.liuyq.java8.optional;

import lombok.*;

import java.util.Date;

/**
 * Created by liuyq on 2019/8/13.
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private String user;

    private Date birthady;

    private String birthdayStr;

}
