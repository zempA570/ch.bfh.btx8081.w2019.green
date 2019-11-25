import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class LoginUi extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout id="vaadinVerticalLayout" style="width: 100%; height: 100%; justify-content: center; align-items: center;">
 <label id="label">Einloggen</label>
 <vaadin-text-field label="Benutzername" placeholder="Placeholder" id="benutzername" style="align-self: center;"></vaadin-text-field>
 <vaadin-password-field label="Password" placeholder="Enter password" value="secret1" id="password" style="align-self: center;"></vaadin-password-field>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-self: center;">
  <button id="button">Registrieren</button>
  <button id="button1">Einloggen</button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'login-ui';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(LoginUi.is, LoginUi);
