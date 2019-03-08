#version 330 core

layout (location = 0) in vec4 position;
layout (location = 1) in vec2 tc;

uniform mat4 pr_matrix;
uniform mat4 vw_matrix;
uniform mat4 model_matrix;

out vec2 outTextureCoord;

void main() {
    
    gl_Position = pr_matrix * vw_matrix * model_matrix * position;
    outTextureCoord = tc;
    
}
