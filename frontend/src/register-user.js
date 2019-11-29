import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';

class RegisterUser extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: center; justify-content: center;">
 <label id="label">Registrieren</label>
 <vaadin-text-field label="Benutzername" placeholder="" id="benutzername"></vaadin-text-field>
 <vaadin-password-field label="Passwort " placeholder="Enter password" value="secret1" id="passwort"></vaadin-password-field>
 <vaadin-password-field label="Passwort wiederholen" placeholder="Enter password" value="secret1" id="passwortWiederholen"></vaadin-password-field>
 <button id="button" style="flex-grow: 0; flex-shrink: 0;">Konto erstellen</button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'register-user';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(RegisterUser.is, RegisterUser);
