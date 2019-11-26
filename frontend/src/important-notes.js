import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class ImportantNotes extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: flex-start;">
 <label id="label">Important Notes </label>
 <vaadin-vertical-layout>
  <vaadin-horizontal-layout style="flex-grow: 0; flex-shrink: 0; align-self: flex-start;" id="vaadinHorizontalLayout">
   <label id="addDate">21.10.19</label>
   <label id="username" style="flex-grow: 0; flex-shrink: 0; align-self: center;">Username </label>
  </vaadin-horizontal-layout>
  <label>Medikamente vergessen</label>Hat die Medikamente nicht eingenommen 
  <vaadin-horizontal-layout id="vaadinHorizontalLayout1" content="Hat die Medikamente nicht eingenommen">
   <label style="align-start">18.10.19</label>
   <label id="username" style="align-end">Username </label>
  </vaadin-horizontal-layout>
  <label>Arzttermin vom 18.10.19</label>generelle Verschlechterung des Zustands wurde festgestellt 
 </vaadin-vertical-layout>
 <vaadin-button id="vaadinButton" style="align-self: center;">
  <iron-icon icon="lumo:plus" slot="prefix" id="ironIcon"></iron-icon>Add 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'important-notes';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ImportantNotes.is, ImportantNotes);
