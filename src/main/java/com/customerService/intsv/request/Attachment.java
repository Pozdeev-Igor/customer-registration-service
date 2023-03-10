package com.customerService.intsv.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
    private String name;
    private byte[] data;
    private String mimeType;
}
