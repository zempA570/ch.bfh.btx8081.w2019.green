import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class InfoboxDelete extends PolymerElement {

 static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-vertical-layout theme="margin">
  <vaadin-text-field label="Name" placeholder="Placeholder"></vaadin-text-field>
  <vaadin-text-field label="Vorname" placeholder="Placeholder"></vaadin-text-field>
  <vaadin-text-field label="Telefonnummer" placeholder="Placeholder"></vaadin-text-field>
  <vaadin-text-field label="Adresse" placeholder="Placeholder"></vaadin-text-field>
  <vaadin-text-field label="PLZ" placeholder="Placeholder"></vaadin-text-field>
  <vaadin-text-field label="Ort" placeholder="Placeholder"></vaadin-text-field>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout theme="margin">
  <vaadin-checkbox>
    Wichtige Telefonnummer 
  </vaadin-checkbox>
  <vaadin-checkbox>
    Wichtige Adresse 
  </vaadin-checkbox>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="margin">
  <vaadin-horizontal-layout theme="margin">
   <vaadin-button theme="primary error">
    Loeschen
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'infobox-add';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(InfoboxDelete.is, InfoboxDelete);
