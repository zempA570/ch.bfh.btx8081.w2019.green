import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';

class EntryImportantnotes extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<label>Wichtige Information erfassen</label>
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: flex-start;">
 <vaadin-date-picker label="Wann ist es vorgefallen" placeholder="Datum auswählen"></vaadin-date-picker>
 <vaadin-text-field placeholder="Username"> // DropDown Liste?
  <iron-icon icon="lumo:user" slot="prefix"></iron-icon>
 </vaadin-text-field>
 <vaadin-text-field label="Titel" placeholder="Titel"></vaadin-text-field>
 <vaadin-text-area placeholder="Was ist vorgefallen?"></vaadin-text-area>
 <button style="align-self: center; flex-grow: 0; flex-shrink: 0;">add</button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'entry-importantnotes';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(EntryImportantnotes.is, EntryImportantnotes);
