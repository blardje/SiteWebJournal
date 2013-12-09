<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div id="positionArticle">
	<div id="positionArticle2">
		<span>Déposer vos articles ici</span> <input type="text"
			name="localisationInput" id="localisationInput" value="" />
		<!--autocomplete="on"-->
		<input type="text" name="rubrique" id="rubriqueInput" value="Rubrique"
			list="rubrique"
			onfocus="if (this.value === 'Rubrique') {
			    this.value = '';
			    this.style.color = '#000000';
			}"
			onblur="if (this.value === '') {
			    this.value = 'Rubrique';
			    this.style.color = '#666';
			}" />
		<datalist id="rubrique">
			<option value="A la une"></option>
			<option value="Economie"></option>
			<option value="Sport"></option>
			<option value="Culture"></option>
			<option value="Petite annonce"></option>
			<option value="Location/Achat"></option>
		</datalist>
	</div>
	<div id="positionArticle3">
		<input type="text" name="articleInput" id="articleInput"
			value="Article ..."
			onfocus="if (this.value === 'Article ...') {
			    this.value = '';
			    this.style.color = '#000000';
			}"
			onblur="if (this.value === '') {
			    this.value = 'Article ...';
			    this.style.color = '#666';
			}" />
		<input type="button" name="publier" value="publier" />
	</div>
	<div id="openCreationArticle">
		<div class="arrow down"></div>
		<div class="arrow down"></div>
	</div>
	<!--<select id="combobox">
<option value="">Select one...</option>
<option value="ActionScript">ActionScript</option>
<option value="AppleScript">AppleScript</option>
<option value="Asp">Asp</option>
<option value="BASIC">BASIC</option>
</select>-->

</div>

