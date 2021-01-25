package com.jelee.spring.springbatch;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class KoreaStats {
    /* 시도명 */
    private String contry;
    /* 전일대비 확진자 증감 */
    private int diiffFromPrevDay;
    /* 확진환자수 */
    private int total;
    /* 사망자 수 */
    private int death;
    /* 발병률 */
    private double incidence;
    /* 일일 검사환자  */
    private int inspection;
}
