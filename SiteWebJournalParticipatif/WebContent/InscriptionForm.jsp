<%@ page pageEncoding="UTF-8" %>
<label for="nomUser">Nom <span class="requis">*</span></label>
<input type="text" id="nomUser" name="nomUser" value="" size="30" maxlength="30" />
<br />

<label for="prenomUser">Prénom </label>
<input type="text" id="prenomUser" name="prenomUser" value="" size="30" maxlength="30" />
<br />
    
<label for="adresseUser">Adresse <span class="requis">*</span></label>
<input type="text" id="adresseUser" name="adresseUser" value="" size="30" maxlength="60" />
<br />

<label for="telephoneUser">Numéro de téléphone <span class="requis">*</span></label>
<input type="text" id="telephoneUser" name="telephoneUser" value="" size="30" maxlength="30" />
<br />

<label for="emailUser">Adresse email</label>
<input type="email" id="emailUser" name="emailUser" value="" size="30" maxlength="60" />
<br />

<label for="imageUser">Image</label>
<input type="file" id="imageUser" name="imageUser" />
<span class="erreur">${form.erreurs['imageUser']}</span>
<br />