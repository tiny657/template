package com.tiny.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiny.comment.Comment;
import com.tiny.service.CommentService;

@Controller
public class CommentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public @ResponseBody String register(@RequestParam Integer documentId, @RequestParam String content) {
		Comment comment = new Comment();
		comment.setDocumentId(documentId);
		comment.setContent(content);
		commentService.register(comment);
		return "<blockquote><p>" + content + "</p></blockquote>";
	}

	@RequestMapping(value = "/comment/{commentId}")
	public String getComments(@PathVariable Integer commentId) {
		StringBuilder commentsHtml = new StringBuilder();
		List<Comment> comments = commentService.getComments(commentId);
		for (Comment comment : comments) {
			commentsHtml.append("<div>").append(comment.getContent()).append("</div>");
		}
		return commentsHtml.toString();
	}
}