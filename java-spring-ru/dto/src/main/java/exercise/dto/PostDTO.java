package exercise.dto;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Comment;
import exercise.model.Post;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class PostDTO {
    private Long id;
    private String title;
    private String body;
    private List<CommentDTO> comments;

    public static PostDTO toDTO(Post post, List<Comment> comments) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        dto.setComments(comments.stream()
                .filter(p -> p.getPostId() == post.getId())
                .map(CommentDTO::toDto)
                .toList());
        return dto;
    }
    public static List<PostDTO> toDTO(List<Post> posts, List<Comment> comments) {
        var result = new ArrayList<PostDTO>();
        for (Post post : posts) {
            var dto = new PostDTO();
            dto.setId(post.getId());
            dto.setTitle(post.getTitle());
            dto.setBody(post.getBody());
            dto.setComments(comments.stream()
                    .filter(p -> p.getPostId() == post.getId())
                    .map(CommentDTO::toDto)
                    .toList());
            result.add(dto);
        }
        return result;
    }
}
// END
