package com.geezylucas.springbootcicd;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document(collectionName = "users")
public class UserEntity {

    @DocumentId
    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Timestamp createdAt;
}
