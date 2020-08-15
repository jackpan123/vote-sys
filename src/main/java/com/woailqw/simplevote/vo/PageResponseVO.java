package com.woailqw.simplevote.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * View object.
 *
 * @author Jack Pan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponseVO<T> {

    private Integer total;

    private List<T> items;

    private Integer page;

    private Integer count;
}
