<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<div class="span12">
			<form:form method="post" action="/" modelAttribute="document">
				<input type="text" class="span12" name="title" placeholder="Title">
				<textarea rows="3" class="span12" name="content"></textarea>
				<button type="submit" class="btn">Save</button>
			</form:form>
		</div>
	</div>
	<div class="accordion" id="accordion2">
		<c:forEach var="document" items="${documents}">
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse${document.documentId}">${document.title}</a>
				</div>
				
				<div id="collapse${document.documentId}" class="accordion-body collapse">
					<div class="accordion-inner">${document.content}</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<!-- Main hero unit for a primary marketing message or call to action -->
	<div class="hero-unit">
		<h1>Hello, world!</h1>
		<p>This is a template for a simple marketing or informational website. It includes a large callout called the hero
			unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
		<p>
			<a class="btn btn-primary btn-large">Learn more &raquo;</a>
		</p>
	</div>

	<!-- Example row of columns -->
	<div class="row">
		<div class="span4">
			<h2>Heading</h2>
			<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
				condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
				odio dui.</p>
			<p>
				<a class="btn" href="#">View details &raquo;</a>
			</p>
		</div>
		<div class="span4">
			<h2>Heading</h2>
			<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
				condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
				odio dui.</p>
			<p>
				<a class="btn" href="#">View details &raquo;</a>
			</p>
		</div>
		<div class="span4">
			<h2>Heading</h2>
			<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta
				felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa
				justo sit amet risus.</p>
			<p>
				<a class="btn" href="#">View details &raquo;</a>
			</p>
		</div>
	</div>

	<hr>

	<footer>
		<p>&copy; Company 2012</p>
	</footer>
</div>