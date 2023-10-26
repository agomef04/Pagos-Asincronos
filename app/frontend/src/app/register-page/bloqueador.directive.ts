import { Directive, HostListener} from '@angular/core';

@Directive({
    selector: "[appBloqueador]"
})

export class BloqueadorDirective{
    constructor(){}

    @HostListener("paste", ["$event"]) blockPaste(e: KeyboardEvent){
        alert("No se puede usar esta acción");
        e.preventDefault();
    }

    @HostListener("copy", ["$event"]) blockCopy(e: KeyboardEvent){
        e.preventDefault();
    }

    @HostListener("cut", ["$event"]) blockCut(e: KeyboardEvent){
        e.preventDefault();
    }
}
