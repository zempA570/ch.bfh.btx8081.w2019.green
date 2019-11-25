import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

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
 <label>Important Notes </label>
 <vaadin-vertical-layout>
  <vaadin-horizontal-layout style="flex-grow: 10; flex-shrink: 0; align-self: flex-start;">
   <label id="addDate">21.10.19</label>
   <label id="username" style="flex-grow: 0; flex-shrink: 0; align-self: flex-end;">Username </label>
  </vaadin-horizontal-layout>Hat die Medikamente nicht eingenommen
  <vaadin-horizontal-layout>
   <label style="align-start">18.10.19</label>
   <label id="username" style="align-end">Username </label>
  </vaadin-horizontal-layout>Arzttermin vom 18.10.19: generelle Verschlechterung des Zustands wurde festgestellt
 </vaadin-vertical-layout>
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
