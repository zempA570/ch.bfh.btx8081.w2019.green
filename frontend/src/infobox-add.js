import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class InfoboxAdd extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="margin" style="align-self: center;">
  <h1>Angaben Hinzufuegen</h1>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="margin" style="align-self: center;">
  <vaadin-text-field label="Name" placeholder="Name"></vaadin-text-field>
  <vaadin-text-field label="Vorname" placeholder="Vorname"></vaadin-text-field>
  <vaadin-text-field label="Telefonnummer" placeholder="Telefonnummer"></vaadin-text-field>
  <vaadin-text-field label="Adresse" placeholder="Adresse"></vaadin-text-field>
  <vaadin-text-field label="PLZ" placeholder="PLZ"></vaadin-text-field>
  <vaadin-text-field label="Ort" placeholder="Ort"></vaadin-text-field>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout theme="margin" style="align-self: center;">
  <vaadin-checkbox>
    Wichtige Telefonnummer 
  </vaadin-checkbox>
  <vaadin-checkbox>
    Wichtige Adresse 
  </vaadin-checkbox>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="margin" style="align-self: center;">
  <vaadin-horizontal-layout theme="margin">
   <vaadin-button theme="primary error">
     Abbrechen 
   </vaadin-button>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="margin">
   <vaadin-button theme="primary success">
     Bestaetigen 
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

customElements.define(InfoboxAdd.is, InfoboxAdd);
